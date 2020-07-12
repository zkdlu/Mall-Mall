import React, { Component } from 'react';
import axios from 'axios';

const API_URL = "http://localhost:8080/articles/";

class Product extends Component {
    constructor(props) {
        super(props);
        this.state = {
            articlePk: this.props.match.params.pk,
            article: '',
            category: '',
            product: '',
            seller: ''
        }
    }

    getProduct = async () => {
        await axios.get(API_URL + this.state.articlePk)
        .then(res => {
            this.setState({
                article: res.data,
                category: res.data.category,
                product: res.data.product,
                seller: res.data.user
            })
        })
    }

    componentDidMount() {
        this.getProduct();
    }

    render() {
        const article = this.state.article;
        const product = this.state.product;
        const category = this.state.category;
        const seller = this.state.seller;

        return (
            <div>
                <div>분류: {category.name}</div>
                <div>{article.title}</div>
                <div>제품명: {product.name}</div>
                <div>제품설명: {product.description}</div>
                <div>제품가격: {product.price}원</div>
                <div>조회수: {article.hits}</div>
                <div>판매자: {seller.id}</div>
            </div>
        )
    }
}

export default Product;