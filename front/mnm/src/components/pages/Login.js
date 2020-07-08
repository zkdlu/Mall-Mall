import React, { Component } from 'react';
import axios from 'axios';
import { instanceOf } from 'prop-types';
import { withCookies, Cookies } from 'react-cookie';

const API_URL = "http://localhost:8080/login";

class Login extends Component {
    static propTypes = {
        cookies: instanceOf(Cookies).isRequired
    };

    constructor(props) {
        super(props);
        const { cookies } = props;
        this.state = {
            isLogin: false,
            userId: cookies.get('userId') || ''
        };
      }

    componentDidMount() {
        const {cookies} = this.props;
        if (cookies.get('userId')) {
            this.setState({
                isLogin: true
            })
        } else {
            this.setState({
                isLogin: false
            })
        }
    }

    handleChangeInput = (e) => {
        const value = e.target.value;
        this.setState({
            [e.target.name]: value
        });
    }

    login = async () => {
        const result = await axios.post(API_URL, {
            user_id: this.state.userId,
            passwd: this.state.password
        }).then(res => {
            if (res.data === true) {
                const {cookies} = this.props;
                cookies.set('userId', this.state.userId);

                alert('로그인 성공');

                this.props.history.push('/main');
            } else {
                alert('로그인 실패');
            }
        })
    }

    logout = () => {
        const {cookies} = this.props;
        cookies.set('userId', this.state.userId);
        cookies.remove('userId');

        window.location.reload(false);
    }

    render() {
        const {isLogin} = this.state;
        return !isLogin ? (
            <div>
                <div>아이디:
                    <input type='text' width='100'
                        name='userId'
                        value={this.state.userId}
                        onChange={this.handleChangeInput} />
                </div>
                <div>패스워드:
                    <input type='password' width='100'
                        name='password'
                        value={this.state.password}
                        onChange={this.handleChangeInput} />
                </div>
                <input type='button' value='로그인' onClick={this.login} />
            </div>
        ) : 
        (
            <div>
                로그인상태
            </div>
        )
    }
}

export default withCookies(Login);