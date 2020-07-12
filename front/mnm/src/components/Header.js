import React, { Component } from 'react'
import { NavLink } from 'react-router-dom'

import './Header.css'

export default class Header extends Component {
    render() {
        return (
            <div className='header-nav'>
                <div className='header-nav-item'>
                    <NavLink activeClassName='active-link' exact to="/">Home</NavLink>
                </div>
                <div className='header-nav-item'>
                    <NavLink activeClassName='active-link' to="/SignIn">SignIn</NavLink>
                </div>
                <div className='header-nav-item'>
                    <NavLink activeClassName='active-link' to="/SignUp">SignUp</NavLink>
                </div>
                <div className='header-nav-item'>
                    <NavLink activeClassName='active-link' to="/article">Article</NavLink>
                </div>
            </div>
        )
    }
}