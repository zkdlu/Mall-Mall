import React, { Component } from 'react';

import Header from './Header.js';
import Container from './Container.js';

class Layout extends Component {
    render() {
        return (
            <div>
                <div>
                    <Header/>
                </div>
                <div>
                    <Container item={this.props.children} />
                </div>
            </div>
        )
    }
}

export default Layout;