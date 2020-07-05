import React, { Component } from 'react';

class Join extends Component {
    checkOverlap = () => {

    }
    
    render() {
        return (
            <div>
                <div>아이디: <input type='text' width='100'/></div>
                <div>패스워드: <input type='password' width='100'/></div>
                <input type='button' value='중복확인'/>
                <input type='button' value='회원가입'/>
            </div>
        )
    }
}

export default Join;