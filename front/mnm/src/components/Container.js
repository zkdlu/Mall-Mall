import React, { Component } from 'react';
import { CookiesProvider } from 'react-cookie';

export default class Container extends Component {
    render() {
        return (
            <div>
                <CookiesProvider>
                    {this.props.item}
                </CookiesProvider>
            </div>
        )
    }
}