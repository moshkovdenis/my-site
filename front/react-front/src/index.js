import ReactDOM from "react-dom/client";
import AllUsers from "./user-service/allUsers";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Layout from "./Layout";
import Header from "./Header";
import './css/App.css';
import './css/quote.css';
import Quote from "./Quote";
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';

export default function Rout() {
    return (
        <div>
            <Header/>
            <BrowserRouter>
                <Routes>
                    <Route path={'/'} element={<Layout/>}/>
                    <Route path={'/all-users'} element={<AllUsers/>}/>
                    <Route path={'/quote'} element={<Quote/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    )
}
const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(<Rout/>);