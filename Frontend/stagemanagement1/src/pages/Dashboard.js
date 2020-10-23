import React, { useState } from "react"
import styled from 'styled-components'
import moment from 'moment'
import Calendar from '../components/calendar/Calendar'
 


const Dashboard = () => {
    const [value, setValue] = useState(moment())

    return (
        <CalendarDiv>
           <Calendar value={value} onChange={setValue}/> 
        </CalendarDiv>
    );   
};

export default Dashboard;


// styled components 

const CalendarDiv = styled.div`
	padding: 150px; 
	
	@media screen and (max-width: 667px){
		padding: 100px 70px 0 20px;
		width: auto;
	}
`;





