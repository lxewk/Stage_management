import React, { useContext, useState } from 'react'
import styled from 'styled-components'
import { colors } from '../styled/global'
import { AuthContext } from '../../contexts/AuthContex'
import { DecorContext } from '../../contexts/DecorContext'
import axios from 'axios'


const NewDecorForm = () => {
    const { state: authState } = useContext(AuthContext)
    const { decorDispatch } = useContext(DecorContext)

    const [name, setName] = useState('')
		const [department, setDepartment] = useState('')
		const [preset, setPreset] = useState('')
		const [description, setDescription] = useState('')
    const [data, setData] = useState('')
    const [error, setError] = useState(false)

    const handleSubmit = (e) => {
        e.preventDefault();
        decorDispatch({type: 'ADD_DECOR', decor: {
            name, department, preset, description
        }});

        const fetchData = async () => {
            try {
                data = await axios({
                    method: 'post',
                    url: 'http://localhost:8080/api/item/save',
                    data: JSON.stringify({
                        itemName: name,
												department: department,
												preset: preset,
												description: description
                    }),
                    headers: {
                        "Content-Type": "application/json",
                        Authorization: `Bearer ${authState.token}`
                    }
                })
                setData(data)
                console.log(data)
            } catch (error) {
                setError(error)
                console.log(error)
            }
        }
        fetchData()

        setName('')
				setDepartment('')
				setPreset('')
				setDescription('')
    }

    return (
				<DecorCard>
					<DecorCardContainer>
						<DecorFormCnt onSubmit={handleSubmit}>
							<DecorCardHead>New Item</DecorCardHead>
							<DecorLabel htmlFor="name">
								Name
							<DecorInput 
								type="text"  
								value={name}
								onChange={(e) => setName(e.target.value)} 
								required 
							/>
							</DecorLabel>
							<DecorLabel htmlFor="department">
								Department
							<DecorInputEnum 
								type="text"  
								value={department}
								onChange={(e) => setDepartment(e.target.value)} 
								required 
							/>
							</DecorLabel>
							<DecorLabel htmlFor="preset">
								Preset position
							<DecorInputEnum 
								type="text"  
								value={preset}
								onChange={(e) => setPreset(e.target.value)}  
							/>
							</DecorLabel>
							<DecorLabel htmlFor="description">
								Description
							<DecorInput 
								type="text"  
								value={description}
								onChange={(e) => setDescription(e.target.value)}  
							/>
							</DecorLabel>
							<DecorLabel htmlFor="add">
								Add Item
							<DecorSubmitBtn 
								type="submit" 
								value="▶︎" 
							/>
							</DecorLabel>
						</DecorFormCnt>
					</DecorCardContainer>
				</DecorCard>
    )
}

export default NewDecorForm;


// styled components

const DecorCard = styled.div`
	box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  height: 70%;
  width: 45%;

  &:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
  }
  
  @media screen and (max-width: 667px){
    width: 85%;
		align-self: center;
		background-color: ${colors.logincardblue};
  }
`;

const DecorCardContainer = styled.div`
  padding-left: 7%;
  padding-right: 7%;
  height: 100%;
`;

const DecorCardHead = styled.h1`
	font-size: 2.5rem;
`;

const DecorFormCnt = styled.form`
	display: flex;
  height: 80%;
  flex-direction: column;
  justify-content: space-around;
  align-self: center;	
`;

const DecorLabel = styled.label`
	display: flex;
	flex-direction: column;
	
	@media screen and (max-width: 667px) {
		font-size: small;
	}
`;

const DecorInput = styled.input`
  padding-left: 10px;
  padding-right: 1px;
  height: 40px;
  border-radius: 5px;
  border: .5px solid rgb(143, 143, 143);
	font-size: 15px;
`;

const DecorInputEnum = styled.input`
	padding-left: 10px;
  padding-right: 1px;
  height: 40px;
  border-radius: 5px;
  border: .5px solid rgb(143, 143, 143);
	font-size: 15px;
`;

const DecorSubmitBtn = styled.input`
	padding-left: 10px;
  padding-right: 1px;
  height: 40px;
  border-radius: 5px;
  border: .5px solid rgb(143, 143, 143);
	font-size: x-large;
	background-color: ${colors.lavender};
	color: ${colors.black};
	cursor: pointer;
	
	&:hover {
    background-color: ${colors.stage};
  }

	@media screen and (max-width: 667px) {
		font-size: large;
	}
`;