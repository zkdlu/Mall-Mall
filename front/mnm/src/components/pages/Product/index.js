import React, { Component } from 'react'
import { Api_getArticle } from '../../../services/ArticleApi';
import NewProduct from './createPage'

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

    getArticle = async () => {
        const {articlePk} = this.state;

        await Api_getArticle(articlePk)
            .then(res => {
                this.setState({
                    article: res.data,
                    category: res.data.category,
                    product: res.data.product,
                    seller: res.data.user
                })
            });
    }

    componentDidMount() {
        this.getArticle();
    }

    render() {
        const {article, product, category, seller} = this.state;

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

export {Product, NewProduct};