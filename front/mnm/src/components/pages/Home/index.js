import React, { Component } from 'react'
import { Api_getArticles } from '../../../services/ArticleApi';

class Home extends Component {
    state = {
        isLoaded: false
    }

    getArticles = async () => {
        await Api_getArticles()
            .then(res => {
                this.setState({
                    isLoaded: true,
                    articles: res.data
                })
            });
    }

    addArticle = () => {
        this.props.history.push('/newarticle');
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
                <div>
                    <input type='button' value='제품 등록' onClick={this.addArticle} />
                </div>
            </div>
        );
    }
}

export default Home;