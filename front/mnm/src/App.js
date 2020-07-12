import React, { Component } from 'react';
import { Route } from 'react-router';
import Layout from './components/Layout.js';

import Home from './components/pages/Home.js';
import Join from './components/pages/Join.js';
import Login from './components/pages/Login.js';
import Main from './components/pages/Main.js';
import Article from './components/pages/Article.js';
import NewArticle from './components/pages/NewArticle.js';
import Product from './components/pages/Product.js';
import { BrowserRouter } from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <Layout>
          <Route exact path='/' component={Home} />
          <Route path='/join' component={Join} />
          <Route path='/login' component={Login} />
          <Route path='/main' component={Main} />
          <Route exact path='/article' component={Article} />
          <Route path='/newarticle' component={NewArticle} />
          <Route path='/article/:pk' component={Product} />
        </Layout>
      </BrowserRouter>
    )
  }
}
export default App;