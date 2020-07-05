import * as React from 'react';
import { Link, NavLink } from 'react-router-dom';

import './Header.css';

export default class Header extends React.Component {
    render() {
        return (
            <div className='header-nav'>
                <div class='header-nav-item'>
                    <NavLink activeClassName='active-link' exact to="/">Home</NavLink>
                </div>
                <div className='header-nav-item'>
                    <NavLink activeClassName='active-link' to="/join">Join</NavLink>
                </div>
                <div className='header-nav-item'>
                    <NavLink activeClassName='active-link' to="/login">Login</NavLink>
                </div>
            </div>
        )
    }
}