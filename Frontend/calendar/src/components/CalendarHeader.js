import React from 'react'
import styled from 'styled-components'

const CalendarHeader = ({value, setValue}) => {

    function currMonthName() {
        return value.format('MMMM')
    }

    function currYear() {
        return value.format('YYYY')
    }

    function prevMonth() {
        return value.clone().subtract(1, 'month')
    }

    function nextMonth() {
        return value.clone().add(1, 'month')
    }

    function thisMonth() {
        return value.isSame(new Date(), 'month')
    }

    return (
        <CalHeader>
            <CalHeaderPrevious 
                onClick={() => !thisMonth() && setValue(prevMonth())}>
                {!thisMonth() ? String.fromCharCode(171) : null}
            </CalHeaderPrevious>
            <div>
                {currMonthName()} {currYear()}
            </div>
            <CalHeaderNext 
                onClick={() => setValue(nextMonth())}>
                {String.fromCharCode(187)}
            </CalHeaderNext>
        </CalHeader>
    )
}

export default CalendarHeader;

// Styled-Components

const CalHeader = styled.div`
	background-color: var(--light-blue);
  text-align: center;
  min-height: 2rem;
  line-height: 2rem;
  color: var(--black);
  font-family: var(--font-book);
  font-weight: 700;
  display: flex;
`;

const CalHeaderPrevious = styled.div`
	flex: 1;
  text-align: left;
  margin-left: 1rem;
`;

const CalHeaderNext = styled.div`
	flex: 1;
  text-align: right;
  margin-right: 1rem;
`;