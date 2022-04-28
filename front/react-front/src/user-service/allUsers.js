import useFetch from "../useFetch";
import {Link} from "react-router-dom";

const AllUsers = () => {
    const [data] = useFetch("http://localhost:8888/api/v1/user/get-all-users");
    return (
        <div>
            <h2>All Users</h2>
            {data && data.map((item) => {
                return <p key={item.id}>Name: {item.name}, Email: {item.email}, Age: {item.age}</p>;
            })}
            <Link to="/" className={'home-link'}>Back to Home</Link>
        </div>
    );
};

export default AllUsers;
