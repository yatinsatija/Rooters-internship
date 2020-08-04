import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import TypeComponent1 from "../components/bus-type";

function TypeContainer1() {
    const selectedTypeList = useSelector((state: State) => state.app.filters.type);
    const dispatch = useDispatch();
    const onTypeChange: (label: string) => void = React.useCallback((label) => {
        const updatedList : string[] = selectedTypeList.filter(type => type !== label)
        if(selectedTypeList.length !== updatedList.length) {
            dispatch({
                type: 'change-bus-type',
                payload: updatedList
            });
        } else {
            dispatch({
                type: 'change-bus-type',
                payload: [...updatedList, label]
            });
        }
    }, [dispatch, selectedTypeList]);
    return (
        <TypeComponent1
            onTypeChange={onTypeChange}
            selectedTypeList={selectedTypeList}
        />
    );
}

export default TypeContainer1;
