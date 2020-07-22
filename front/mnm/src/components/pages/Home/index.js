import React, { Component } from 'react';
import Button from '@material-ui/core/Button';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import CssBaseline from '@material-ui/core/CssBaseline';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import Copyright from '../../Copyright'
import { withStyles } from '@material-ui/core/styles';
import { Api_getArticles } from '../../../services/ArticleApi';

const useStyles = makeStyles((theme) => ({
  icon: {
    marginRight: theme.spacing(2),
  },
  heroContent: {
    backgroundColor: theme.palette.background.paper,
    padding: theme.spacing(8, 0, 6),
  },
  heroButtons: {
    marginTop: theme.spacing(4),
  },
  cardGrid: {
    paddingTop: theme.spacing(8),
    paddingBottom: theme.spacing(8),
  },
  card: {
    height: '100%',
    display: 'flex',
    flexDirection: 'column',
  },
  cardMedia: {
    paddingTop: '56.25%', // 16:9
  },
  cardContent: {
    flexGrow: 1,
  },
  footer: {
    backgroundColor: theme.palette.background.paper,
    padding: theme.spacing(6),
  },
}));

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
      <React.Fragment>
        <CssBaseline />

        <main>
          <div>
            <Container maxWidth="sm">
              <Typography component="h1" variant="h2" align="center" color="textPrimary" gutterBottom>
                제목
              </Typography>
              <Typography variant="h5" align="center" color="textSecondary" paragraph>
                내용
              </Typography>
              <div>
                <Grid container spacing={1} justify="center">
                  <Grid item>
                    
                  </Grid>
                </Grid>
              </div>
            </Container>
          </div>
          <Container maxWidth="md">
            <Grid container spacing={4}>
              {
                isLoaded ? articles.map((a, i) => {
                  return (
                    <Grid item key={i} xs={12} sm={6} md={4}>
                      <Card>
                        <CardMedia
                          image="https://source.unsplash.com/random"
                          title={a.title}
                        />
                        <CardContent>
                          <Typography gutterBottom variant="h5" component="h2">
                            {a.title}
                          </Typography>
                          <Typography>
                            {a.description}

                          </Typography>
                        </CardContent>
                        <CardActions>
                          <Button size="small" color="primary">
                            View
                           </Button>
                          <Button size="small" color="primary">
                            Edit
                          </Button>
                        </CardActions>
                      </Card>
                    </Grid>
                  )
                }) : 'empty'
              }
            </Grid>
          </Container>
        </main>
        {/* Footer */}
        <Box mt={8}>
          <Copyright />
        </Box>
        {/* End footer */}
      </React.Fragment>
    );
  }
}

export default withStyles(useStyles)(Home);


// import React, { Component } from 'react'
// 

// class Home extends Component {
//     state = {
//         isLoaded: false
//     }

//     getArticles = async () => {
//         await Api_getArticles()
//             .then(res => {
//                 this.setState({
//                     isLoaded: true,
//                     articles: res.data
//                 })
//             });
//     }

//     addArticle = () => {
//         this.props.history.push('/newarticle');
//     }

//     componentDidMount() {
//         this.getArticles();
//     }

//     render() {
//         const { isLoaded, articles } = this.state;
//         return (
//             <div>
//                 {
//                     isLoaded ? articles.map((a, i) => {
//                         return (
//                             <div key={i}>
//                                 <a href={`/article/${a.pk}`}>{a.title}</a>
//                             </div>
//                         )
//                     }) : 'empty'
//                 }
//                 <div>
//                     <input type='button' value='제품 등록' onClick={this.addArticle} />
//                 </div>
//             </div>
//         );
//     }
// }

// export default Home;