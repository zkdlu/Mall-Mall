import React, { Component } from 'react';
import { instanceOf } from 'prop-types';
import { withCookies, Cookies } from 'react-cookie';

class Main extends Component {
    static propTypes = {
        cookies: instanceOf(Cookies).isRequired
    };

    logout = () => {
        const {cookies} = this.props;
        cookies.remove('userId');

        window.location.reload(false);
    }
    
    componentDidMount() {
        const { cookies } = this.props;

        if (!cookies.get("userId")) {
            this.props.history.push('/login');
        }
    }

    render() {
        return (
            <div>
                로그인 중이면 유지
                아니면 login으로
                <input type='button' value='로그아웃' onClick={this.logout}/>
            </div>
        )
    }
}

export default withCookies(Main);