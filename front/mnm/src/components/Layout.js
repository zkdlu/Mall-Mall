import React, { Component } from 'react';

import Header from './Header.js';
import Container from './Container.js';

class Layout extends Component {
    render() {
        return (
            <div>
                <Header />
                <Container item={this.props.children} />
            </div>
        )
    }
}

export default Layout;