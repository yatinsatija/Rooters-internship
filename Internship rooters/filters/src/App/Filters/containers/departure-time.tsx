import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import TypeComponent2 from "../components/departure-time";

function TypeContainer2() {
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
        <TypeComponent2
            onTypeChange={onTypeChange}
            selectedTypeList={selectedTypeList}
        />
    );
}

export default TypeContainer2;
