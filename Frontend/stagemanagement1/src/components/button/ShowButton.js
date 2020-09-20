import React, { useContext} from 'react';

import { UserRoleContext } from '../contexts/UserRoleProvider';

import { ShowBtn } from './ShowButtonStyle';



export const ShowButton = () => {
    const { omdatHetEenFunctieMoetZijnFunctie } = useContext(UserRoleContext);

    
    return(
    
        <ShowBtn
            onClick={() => omdatHetEenFunctieMoetZijnFunctie()}
        >
            
        </ShowBtn>
        
    );
}

export default ShowButton;



