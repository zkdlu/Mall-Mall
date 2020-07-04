import React, { Component } from 'react';
import PropTypes from "prop-types";


export default class App extends Component {
  state = {
    isLoading: true
  }

  componentDidMount() {
    setTimeout(() => {
      this.setState({isLoading: false});
    }, 6000);
  }

  render() {
    const { isLoading } = this.state;
    return (<div>
      {isLoading ? "Loading" : "We are ready"}
    </div>);
  }
}

const data = [
  {
    id:1,
    name: "커버낫",
    image: "https://image.msscdn.net/images/goods_img/20180330/746280/746280_2_125.jpg",
    rating: 5
  },
  {
    id:2,
    name: "내셔널지오그래픽",
    image: "https://image.msscdn.net/images/goods_img/20190329/999287/999287_2_125.jpg",
    rating: 4.3
  },
  {
    id:3,
    name: "로얄라이프",
    image: "https://image.msscdn.net/images/goods_img/20170418/540421/540421_7_125.jpg",
    rating: 2.7
  },
  {
    id:4,
    name: "로맨틱 파이어리츠",
    image: "https://image.msscdn.net/images/goods_img/20190419/1021715/1021715_2_125.jpg",
    rating: 3.6
  },
  {
    id:5,
    name: "프리즘웍스",
    image: "https://image.msscdn.net/images/goods_img/20200513/1443918/1443918_1_125.jpg",
    rating: 4.1    
  },
  {
    id:6,
    name: "트래블",
    image: "https://image.msscdn.net/images/goods_img/20200502/1429495/1429495_1_125.jpg",
    rating: 1.6
  },
];