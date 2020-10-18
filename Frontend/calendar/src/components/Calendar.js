import React, { useState, useEffect } from 'react'

import styled from 'styled-components'
import buildCalendar from './build'
import dayStyles, { beforeToday } from './styles'
import CalendarHeader from './CalendarHeader'

const Calendar = ({value, onChange}) => {
    const [calendar, setCalendar] = useState([])
    
    useEffect(() => {     
        setCalendar(buildCalendar(value))
		}, [value])
		
    return(
			<CalContainer>
				<CalendarHeader value={value} setValue={onChange}/>
				<CalBody>
					<CalDayNames>
						{["s", "m", "t", "w", "t", "f", "s"].map((d) => (
							<CalWeekDayNames>{d}</CalWeekDayNames>
						))}
					</CalDayNames>
					{calendar.map((week) => (
						<CalWeek>					
							{week.map((day) => (
									<CalDay
										onClick={() => !beforeToday(day) && onChange(day)}
								>
										<CalDayInnerDiv
											className={dayStyles(day, value)}
									>
											{day.format('D').toString()}
										</CalDayInnerDiv> 
									</CalDay>                     
							))}
						</CalWeek>             
					))}
				</CalBody>
			</CalContainer>
    )
}

export default Calendar;

// Styled Components

const CalContainer = styled.div`
    box-sizing: border-box;
    font-size: 1rem;
    max-width: 400px;
`;

const CalBody = styled.div`
	border: 1px solid var(--light-blue);
`;

const CalDayNames = styled.div`
	display: flex;
  flex-wrap: wrap;
  max-width: 1000px;
  margin: 0 auto;
  align-items: center;
`;

const CalWeekDayNames = styled.div`
	background-color: white;
  width: calc(100% / 7);
  height: 44px;
  line-height: 44px;
  text-align: center;
  text-transform: uppercase;
  color: var(--black);
  font-weight: 400;
`;

const CalWeek = styled.div`
    width: 100%;
`;

const CalDay = styled.div`
		position: relative;
		width: calc(100% / 7);
		height: 44px;
		display: inline-block;
		background-color: white;
		padding: 0;
		margin: 0;
		box-sizing: border-box;
		z-index: 1;
		text-align: center;
`;


const CalDayInnerDiv = styled.div`
	width: 54px;
  height: 44px;
  position: relative;
  color: var(--black);
  z-index: 100;
	line-height: 44px;

	&.selected {
			background-color: var(--red);
			color: var(--white);
			font-weight: bold;
		}

	&.before {
		color: var(--grey)
	}

	&.today {
		background-color: var(--grey)
	}
`;
