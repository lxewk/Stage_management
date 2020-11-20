import React, { useEffect, useContext } from 'react'
import styled from 'styled-components'
import { DecorContext } from '../contexts/DecorContext'
import DecorForm from '../components/item/DecorForm'


const AddItem = () => {
    const { decors } = useContext(DecorContext)

    useEffect(() => {
        console.log('useEffect hook Decors ran', decors)
    }, [decors])


    return ( 
        <AddItemContainer>
            <DecorForm {...decors}/>
        </AddItemContainer>
     );
}
 
export default AddItem;

// styled components

const AddItemContainer = styled.div`
	display: flex;
	align-items: center;
	height: calc(100vh);
  padding-top: 5%;
  padding-left: 5%;
	padding-right: 5%;
	
	@media screen and (max-width: 667px){
    justify-content: flex-start;
  }
`;








// const [decorCount, setDecorCount] = useState(0)

// useEffect(() => {
//     console.log('useEffect hook decorCount ran', decorCount);
// }, [decorCount])

/* <AddItemBtn onClick={() => 
                setDecorCount(decorCount + 1)}>Decor count: {decorCount}
            </AddItemBtn>
            
const AddItemBtn = styled.button`
  padding: 5px;
  height: 40px;
  border-radius: 5px;
  border: .5px solid rgb(143, 143, 143);
  font-size: 15px;
`; */