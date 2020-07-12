import React, { Component } from 'react';
import axios from 'axios';
import { NavLink } from 'react-router-dom';

const API_URL = "http://localhost:8080/articles";

class Article extends Component {
    state = {
        isLoaded: false,
        articles:[]
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

    componentDidMount() {
        this.getArticles();
    }

    render() {
        const {isLoaded, articles} = this.state;
        return (
            <div>
                {
                    isLoaded ? articles.map((a,i) => {
                        return (
                            <div key={i}>
                                <a href={`/article/${a.pk}`}>{a.title}</a>
                            </div>
                        )
                    }) : '없음'
                }
            </div>
        )
    }
}

export default Article;