import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom'
import Layout from './Layout'
import SignIn from './pages/SignIn'
import SignUp from "./pages/SignUp"
import Home from "./pages/Home"
import {Product, NewProduct} from './pages/Product'

export default class App extends Component {
  render() {
    return (
      <Router>
        <Layout>
          <Route exact path='/' component={Home} />
          <Route exact path='/SignIn' component={SignIn} />
          <Route exact path='/SignUp' component={SignUp} />
          <Route path='/article/:pk' component={Product} />
          <Route path='/newarticle' component={NewProduct} />
        </Layout>
      </Router>
    )
  }
}