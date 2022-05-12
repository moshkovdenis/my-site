import React from "react";

const Square = (props) => {
    return (
        <button className="square" onClick={() => { console.log('клик'); }}>
            {props.value}
        </button>
    )
}

export default Square;
