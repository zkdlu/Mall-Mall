import React, { Component } from 'react'
import { Api_getArticles } from '../../../services/ArticleApi';

class Home extends Component {
    state = {
        isLoaded: false
    }

    getArticles = async () => {
        await Api_getArticles()
            .then(res => {
                console.log(res.data);
                this.setState({
                    isLoaded: true,
                    articles: res.data
                })
            });
    }

    componentDidMount() {
        this.getArticles();
    }

    render() {
        const { isLoaded, articles } = this.state;
        return (
            <div> 
                {
                    isLoaded ? articles.map((a, i) => {
                        return (
                            <div key={i}>
                                <a href={`/article/${a.pk}`}>{a.title}</a>
                            </div>
                        )
                    }) : 'empty'
                }
            </div>
        );
    }
}

export default Home;