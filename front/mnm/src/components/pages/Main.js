import React, { Component } from 'react';
import axios from 'axios';
import { instanceOf } from 'prop-types';
import { withCookies, Cookies } from 'react-cookie';

const API_URL = "http://localhost:8080/seller";

class Main extends Component {
    static propTypes = {
        cookies: instanceOf(Cookies).isRequired
    };

    state = {
        userId: '',
        isSeller: false
    }

    logout = () => {
        const { cookies } = this.props;
        cookies.remove('userId');

        window.location.reload(false);
    }

    getPermission = async () => {
        await axios.post(API_URL, {
            user_id: this.state.userId
        }).then(res => {
            if (res.data === true) {
                this.setState({
                    isSeller: true
                })

                alert(this.state.isSeller);
                //window.location.reload(false);
            }
        })
    }

    componentDidMount() {
        const { cookies } = this.props;

        if (!cookies.get("userId")) {
            this.props.history.push('/login');
        } else {
            const isSeller = cookies.get("userState") == 1 ? true : false;
            this.setState({
                userId: cookies.get("userId"),
                isSeller: isSeller
            })
        }
    }

    render() {
        return (
            <div>
                <div>
                    로그인 중이면 유지
                    아니면 login으로
                    {
                        this.state.isSeller ? <div>판매자</div> : <input type='button' value='판매자로' onClick={this.getPermission} />
                    }
                </div>
                <input type='button' value='로그아웃' onClick={this.logout} />
            </div>
        )
    }
}

export default withCookies(Main);