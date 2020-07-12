import React, { Component } from 'react'
import Header from './Header'
import Container from './Container'

export default class Layout extends Component {
    render() {
        return (
            <div>
                <Header/>
                <Container item={this.props.children} />
            </div>
        )
    }
}

