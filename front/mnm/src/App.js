import React, { Component } from 'react';
import { Route } from 'react-router';
import Layout from './components/Layout.js';

import Home from './components/pages/Home.js';
import Join from './components/pages/Join.js';
import Login from './components/pages/Login.js';
import { BrowserRouter } from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <Layout>
          <Route exact path='/' component={Home} />
          <Route path='/join' component={Join} />
          <Route path='/login' component={Login} />
        </Layout>
      </BrowserRouter>
    )
  }
}

export default App;
