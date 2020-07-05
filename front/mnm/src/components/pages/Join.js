import React, { Component } from 'react';
import axios from 'axios';

class Join extends Component {
    checkOverlap = () => {
        axios.get("http://localhost:8080/join?user_id=zkdlu") 
            .then(res => { console.log(res);}) 
            .catch(res => console.log(res));
    }

    render() {
        return (
            <div>
                <div>아이디: <input type='text' width='100'/></div>
                <div>패스워드: <input type='password' width='100'/></div>
                <input type='button' value='중복확인' onClick={this.checkOverlap}/>
                <input type='button' value='회원가입'/>
            </div>
        )
    }
}

export default Join;