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
        completed: false
    }

    logout = () => {
        const { cookies } = this.props;
        cookies.remove('userId');
        cookies.remove('userPk');
        cookies.remove('userSeller');

        window.location.reload(false);
    }

    getPermission = async () => {
        await axios.post(API_URL, {
            user_id: this.state.userId
        }).then(res => {
            if (res.data === true) {
                const { cookies } = this.props;
                cookies.set('userSeller', true);

                this.setState({
                    isSeller: true
                })

                window.location.reload(false);
            }
        })
    }

    componentDidMount() {
        const { cookies } = this.props;

        if (!cookies.get("userId")) {
            this.props.history.push('/login');
        } else {
            const isSeller = cookies.get('userSeller') === 'true' ? true : false;
            this.setState({
                userId: cookies.get("userId"),
                isSeller: isSeller,
                completed: true
            })
        }
    }

    render() {
        return (
            <div>
                <div>
                    {
                        this.state.completed === true ? (
                            this.state.isSeller === true ?
                                <div>판매자</div> :
                                <input type='button' value='판매자로' onClick={this.getPermission} />
                        ) : (
                                <div>시발</div>
                            )
                    }
                </div>
                <input type='button' value='로그아웃' onClick={this.logout} />
            </div>
        )
    }
}

export default withCookies(Main);