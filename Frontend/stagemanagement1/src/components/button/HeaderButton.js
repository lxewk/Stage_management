import React, { useContext } from 'react';
import { AuthContext } from "../../../src/App";

import { HeaderBut } from './HeaderButtonStyle';

export const HeaderButton = () => {
    const { state, dispatch } = useContext(AuthContext);

    return(
        <HeaderBut
            outline
            onClick={() =>
            dispatch({
                type: "LOGOUT"
            })
            }
        >
            {state.isAuthenticated && (
                <>
                    <h1>{state.user} (logout)</h1>
                </>
            )}   
        </HeaderBut>
    );
}

export default HeaderButton;