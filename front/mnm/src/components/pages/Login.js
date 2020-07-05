import React, { Component } from 'react';
import axios from 'axios';

const API_URL = "http://localhost:8080/login";

class Login extends Component {
    state = {
        userId: '',
        password: ''
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
                alert('로그인 성공');
            } else {
                alert('로그인 실패');
            }
        })
    }

    render() {
        return (
            <div>
                 <div>아이디: 
                    <input type='text' width='100' 
                        name='userId'
                        value={this.state.userId}
                        onChange={this.handleChangeInput}/>
                </div>
                <div>패스워드: 
                    <input type='password' width='100'
                        name='password'
                        value={this.state.password}
                        onChange={this.handleChangeInput}/>
                </div>
                <input type='button' value='로그인' onClick={this.login}/>
            </div>
        )
    }
}

export default Login;