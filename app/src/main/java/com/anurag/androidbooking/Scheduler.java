package com.anurag.androidbooking;

public class Scheduler {
    int maxPeopleLimit;
    int eachSlotTime;

    public int getMaxPeopleLimit() {
        return maxPeopleLimit;
    }

    public void setMaxPeopleLimit(int maxPeopleLimit) {
        this.maxPeopleLimit = maxPeopleLimit;
    }

    public int getEachSlotTime() {
        return eachSlotTime;
    }

    public void setEachSlotTime(int eachSlotTime) {
        this.eachSlotTime = eachSlotTime;
    }

    public int getPersonPerSlot() {
        return personPerSlot;
    }

    public void setPersonPerSlot(int personPerSlot) {
        this.personPerSlot = personPerSlot;
    }

    int personPerSlot;


}
