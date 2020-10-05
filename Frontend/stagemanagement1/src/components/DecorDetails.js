import React, { useContext } from 'react';
import { DecorContext } from '../contexts/DecorContext';

const DecorDetails = ({ decor }) => {
    const { dispatch } = useContext(DecorContext);
    return (
        <li onClick={() => dispatch({type: 'REMOVE_DECOR', id: decor.id})}>
            <div>{ decor.name }</div>
            <div>{ decor.department }</div>
        </li>
    )
}

export default DecorDetails
