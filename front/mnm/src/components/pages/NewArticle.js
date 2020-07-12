import React, { Component } from 'react';
import axios from 'axios';
import { instanceOf } from 'prop-types';
import { withCookies, Cookies } from 'react-cookie';

const API_URL = "http://localhost:8080/articles";
const CATEGORY_URL = "http://localhost:8080/categories";

class NewArticle extends Component {
    static propTypes = {
        cookies: instanceOf(Cookies).isRequired
    };

    constructor(props) {
        super(props);
        this.state = {
            productStock: 0,
            productPrice: 0,
            userId: '',
            categories: []
        }
    }

    addNewArticle = async () => {
        await axios.post(API_URL, {
            user: {
                user_id: this.state.userId
            },
            product: {
                name: this.state.productName,
                stock: this.state.productStock,
                sales: 0,
                price: this.state.productPrice,
                description: this.state.productDescription,
                state: 0
            },
            category: {
                name: this.state.productCategory,
                state: 0
            },
            title: this.state.articleTitle,
            description: this.state.articleDescription,
            hits: 0,
            state: 0        
        }).then(res => {
            if (res.data === true) {
                alert('추가 되었습니다.');
                this.props.history.push('/article');
            } else {
                alert('실패');
                window.location.reload(false);
            }
        })
    }

    getCategories = async () => {
        await axios.get(CATEGORY_URL)
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
        const {cookies} = this.props;

        if (!cookies.get("userId")) {
            this.props.history.push('/login');
        } else {
            this.setState({
                userId: cookies.get("userId"),
            })
        }

        this.getCategories();
    }

    handleChangeInput = (e) => {
        const value = e.target.value;
        this.setState({
            [e.target.name]: value
        });

        console.log(e.target.name + ':' + value);
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
                <input type="button" value="생성" onClick={this.addNewArticle}/>
            </div>
        )
    }
}

export default withCookies(NewArticle);