import NavBar from "./Components/NavBar.js";
import BookDetails from "./Components/BookDetails.js";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import './App.css';

function App() {
  return (
    <Router>
      <Switch>
      <Route path="/:id" component={BookDetails}/>
      <Route path="/home" component={NavBar}/>
      <Route path="/" component={NavBar} />
      </Switch>
    </Router>

  );
}

export default App;
