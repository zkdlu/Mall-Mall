import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import { Link as RouterLink } from 'react-router-dom';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import { withStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import { green, red } from '@material-ui/core/colors';

import CheckCircleIcon from '@material-ui/icons/CheckCircle';
import ErrorIcon from '@material-ui/icons/Error';
import { InputAdornment } from '@material-ui/core';
import { checkOverlap, join } from '../../../services/UserApi';
import Copyright from '../../Copyright'

function CheckIdIcon(overlap) {
  if (overlap.overlap === false) {
    return (<CheckCircleIcon style={{ color: green[500] }} />);
  } else {
    return (<ErrorIcon style={{ color: red[500] }} />);
  }
}

const useStyles = theme => ({
  paper: {
    marginTop: theme.spacing(8),
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: '100%', // Fix IE 11 issue.
    marginTop: theme.spacing(3),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
});

class SignUp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      overlap: false,
      name: '',
      user_id: '',
      password: '',
      gender: '',
      home_address: '',
      phone_number: ''
    }
  }

  onCheck = async (event) => {
    const event_user_id = event.target.value;
    checkOverlap(event_user_id)
      .then(res => {
        if (res.data === true) {
          this.setState({ overlap: true, user_id: event_user_id });
          //사용 가능한 아이디
        } else {
          //사용 불가능 아이디
          this.setState({ overlap: false, user_id: event_user_id });
        }
      })
      .catch(res => {
        console.log(res);
      });
  }

  onSignUp = async () => {
    const { name, user_id, password, gender, home_address, phone_number } = this.state;

    if ('' === name.trim() || '' === user_id.trim() || '' === password.trim() || '' === gender.trim() || '' === home_address.trim() || '' === phone_number.trim()) {
      alert("회원 가입 실패");
    } else {
      join(name, user_id, password, gender, home_address, phone_number)
        .then(res => {
          if (res.data === true) {
            alert("회원 가입 성공.");
            this.props.history.push("/SignIn");
          } else {
            alert("회원 가입 실패");
          }
        })
        .catch(res => {
          console.log(res);
        });
    }
  }

  handleChange = event => {
    const id = event.target.name;
    const value = event.target.value;
    
    this.setState({ [id]: value });
  }

  render() {
    const { classes } = this.props;
    const { overlap } = this.state;

    console.log(this.state);
    return (
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <div className={classes.paper}>
          <Avatar className={classes.avatar}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Sign up
        </Typography>
          <form className={classes.form} noValidate>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <TextField
                  autoComplete="fname"
                  variant="outlined"
                  required
                  fullWidth
                  id="name"
                  name="name"
                  label="User Name"
                  autoFocus
                  onChange={this.handleChange}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  id="user_id"
                  name="user_id"
                  label="User Id"
                  autoComplete="user_id"
                  onChange={this.onCheck}
                  InputProps={{
                    startAdornment: (
                      <InputAdornment position="start">
                        <CheckIdIcon overlap={overlap} />
                      </InputAdornment>
                    )
                  }}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  id="password"
                  name="password"
                  label="password"
                  type="password"
                  autoComplete="password"
                  onChange={this.handleChange}
                />
              </Grid>

              <Grid item xs={12}>
                <RadioGroup
                  row
                  aria-label="gender"
                  name="gender"
                  onChange={this.handleChange}
                >
                  <FormControlLabel
                    value="female"
                    label="female"
                    control={<Radio />}
                  />
                  <FormControlLabel
                    value="male"
                    label="male"
                    control={<Radio />}
                  />
                </RadioGroup>
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  id="home_address"
                  name="home_address"
                  label="Home Address"
                  autoComplete="email"
                  onChange={this.handleChange}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  id="phone_number"
                  name="phone_number"
                  label="Phone Number"
                  autoComplete="current-password"
                  onChange={this.handleChange}
                />
              </Grid>

              <Grid item xs={12}>
                <FormControlLabel
                  control={<Checkbox value="allowExtraEmails" color="primary" />}
                  label="I want to receive inspiration, marketing promotions and updates via email."
                />
              </Grid>
            </Grid>
            <Button
              //type="submit"
              fullWidth
              variant="contained"
              color="primary"
              onClick={this.onSignUp}
              className={classes.submit}
            >
              Sign Up
          </Button>
            <Grid container justify="flex-end">
              <Grid item>
                <Link component={RouterLink} to="/SignIn" variant="body2">
                  Already have an account? Sign in
              </Link>
              </Grid>
            </Grid>
          </form>
        </div>
        <Box mt={5}>
          <Copyright />
        </Box>
      </Container>
    );
  }
}

export default withStyles(useStyles)(SignUp);