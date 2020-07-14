import React, { Component } from 'react'
import { Api_insertArticle } from '../../../services/ArticleApi';
import { Api_getCategories } from '../../../services/CategoryApi';

class NewProduct extends Component {
    constructor(props) {
        super(props);
        this.state = {
            productStock: 0,
            productPrice: 0,
            categories: []
        }
    }

    addNewArticle = async () => {
        const { productName, productStock, 
            productPrice, productDescription,
            productCategory, articleTitle, articleDescription 
        } = this.state;

        await Api_insertArticle('zkdlu', productName, productStock,
            productPrice, productDescription, productCategory,
            articleTitle, articleDescription)
            .then(res => {
                console.log(res);
                if (res.data === true) {
                    alert('추가 되었습니다.');
                    this.props.history.push('/');
                } else {
                    alert('실패');
                    window.location.reload(false);
                }
            });
    }

    getCategories = async () => {
        await Api_getCategories()
            .then(res => {
                if (res.data !== null) {
                    this.setState({
                        categories: res.data,
                        productCategory: res.data[0].name
                    })
                }
            })
    }

    componentDidMount() {
        this.getCategories();
    }

    handleChangeInput = (e) => {
        const value = e.target.value;
        this.setState({
            [e.target.name]: value
        });
    }

    render() {
        return (
            <div>
                <div>
                    제목
                <input type='text' width='100'
                        name='articleTitle'
                        value={this.state.articleTitle}
                        onChange={this.handleChangeInput} />
                </div>
                <div>
                    설명
                <input type='text' width='100'
                        name='articleDescription'
                        value={this.state.articleDescription}
                        onChange={this.handleChangeInput} />
                </div>
                <div>
                    제품명
                <input type='text' width='100'
                        name='productName'
                        value={this.state.productName}
                        onChange={this.handleChangeInput} />
                </div>
                <div>
                    제품가격
                <input type='number' width='100'
                        name='productPrice'
                        value={this.state.productPrice}
                        onChange={this.handleChangeInput} />
                </div>
                <div>
                    제품설명
                <input type='text' width='100'
                        name='productDescription'
                        value={this.state.productDescription}
                        onChange={this.handleChangeInput} />
                </div>
                <div>
                    카테고리
                <select name='productCategory'
                        value={this.state.productCategory}
                        onChange={this.handleChangeInput}>
                        {
                            this.state.categories.map((c, i) => {
                                return (
                                    <option key={i} value={c.name}>{c.name}</option>
                                )
                            })
                        }
                    </select>
                </div>
                <div>
                    재고
                <input type='number' width='100'
                        name='productStock'
                        value={this.state.productStock}
                        onChange={this.handleChangeInput} />
                </div>
                <input type="button" value="생성" onClick={this.addNewArticle} />
            </div>
        )
    }
}

export default NewProduct;