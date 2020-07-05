import React, { Component } from 'react';
import axios from 'axios';

const API_URL = "http://localhost:8080/join";

class Join extends Component {
    state = {
        overlap: false,
        userId: '',
        password: '',
        checkedId: '',
        gender:'',
        homeAddress:'',
        phoneNum:''
    }

    checkOverlap = async () => {
        const result = await axios.get(API_URL + '?user_id=' + this.state.userId) 
            .then(res => { 
                const id = this.state.userId;
                this.setState({
                    overlap: res.data,
                    checkedId: id
                })
            }) 
            .catch(res => console.log(res));
    }

    join = async() => {
        const result = await axios.post(API_URL, {
                user_id: this.state.userId,
                passwd: this.state.password,
                gender: this.state.gender === "Male" ? 1 : 0,
                home_address: this.state.homeAddress,
                phone_number: this.state.phoneNum
        }).then(res => {
            if (res.data === true) {
                alert('회원가입 성공');
            } else {
                alert('회원가입 실패');
            }
            console.log(res);
        })
    }

    handleChangeInput = (e) => {
        const value = e.target.value;
        this.setState({
            [e.target.name]: value
        });
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
                <div>성별:
                    <input type='radio' width='100'
                        name='gender' 
                        value="Male"
                        onChange={this.handleChangeInput}/>남
                    <input type='radio' width='100'
                        name='gender'
                        value="Female"
                        onChange={this.handleChangeInput}/>여
                </div>
                <div>주소: 
                    <input type='text' width='100'
                        name='homeAddress'
                        value={this.state.homeAddress}
                        onChange={this.handleChangeInput}/>
                </div>
                <div>핸드폰:
                    <input type='text' width='100'
                        name='phoneNum'
                        value={this.state.phoneNum}
                        onChange={this.handleChangeInput}/>
                </div>
                <input type='button' value='중복확인' onClick={this.checkOverlap}/>
                <input type='button' value='회원가입' onClick={this.join}/>
                <div>
                    {
                        this.state.overlap ? this.state.checkedId + ' 중복임' : this.state.checkedId + ' 중복 아님'
                    }
                </div>
            </div>
        )
    }
}

export default Join;