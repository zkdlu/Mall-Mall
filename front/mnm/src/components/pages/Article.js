import React, { Component } from 'react';
import axios from 'axios';
import { instanceOf } from 'prop-types';
import { withCookies, Cookies } from 'react-cookie';

const API_URL = "http://localhost:8080/articles";

class Article extends Component {
    static propTypes = {
        cookies: instanceOf(Cookies).isRequired
    };

    state = {
        isLoaded: false,
        articles: [],
        isSeller: false
    }

    getArticles = async () => {
        await axios.get(API_URL)
            .then(res => {
                this.setState({
                    isLoaded: true,
                    articles: res.data
                })
            })
    }

    addNewArticle = () => {
        this.props.history.push('/newarticle');
    }

    componentDidMount() {
        const { cookies } = this.props;

        const isSeller = cookies.get('userSeller') === 'true' ? true : false;
        this.setState({
            isSeller: isSeller
        });

        this.getArticles();
    }

    render() {
        const { isLoaded, articles, isSeller } = this.state;
        return (
            <div>
                <div>
                    {
                        isLoaded ? articles.map((a, i) => {
                            return (
                                <div key={i}>
                                    <a href={`/article/${a.pk}`}>{a.title}</a>
                                </div>
                            )
                        }) : '없음'
                    }
                </div>

                <div>
                    {
                        isSeller ? <input type='button' value='제품 등록' onClick={this.addNewArticle}/>
                                : ''
                    }
                </div>
            </div>
        )
    }
}

export default withCookies(Article);