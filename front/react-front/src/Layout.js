import { Outlet, Link } from "react-router-dom";

const Layout = () => {
    return (
        <>
            <div className="container mt-2">
                <Link to="/all-users"><button type="button" className="btn btn-light">Все пользователи</button></Link>
                <Link to="/quote"><button type="button" className="btn btn-light">Цитаты</button></Link>
            </div>
            <Outlet />
        </>
    )
};

export default Layout;