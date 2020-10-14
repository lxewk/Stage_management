import React, { useContext } from 'react';
import { AuthContext } from "../../../contexts/AuthContex";

import { HeaderBut } from './HeaderLogoutButtonStyle';

export const HeaderButton = () => {
    const { state, dispatch } = useContext(AuthContext);

    return(
        <HeaderBut
            to="/"
            outline="true"
            onClick={() =>
            dispatch({
                type: "LOGOUT"
            })
            }
        >
            {state.isAuthenticated && (
                <>
                    <h1><b><i className='ion-log-out' /></b>Logout</h1>
                </>
            )}   
        </HeaderBut>
    );
}

export default HeaderButton;