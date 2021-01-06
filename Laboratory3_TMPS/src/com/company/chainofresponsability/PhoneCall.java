package com.company.chainofresponsability;

public class PhoneCall {
    private int callId;
    private String callerNumber;
    private PhoneCallResponse call;

    public PhoneCall(int callId, String callerNumber, PhoneCallResponse call) {
        super();
        this.callId = callId;
        this.callerNumber = callerNumber;
        this.call = call;
    }

    @Override
    public String toString() {
        return "PhoneCall [callId=" + callId + ", callerNumber=" + callerNumber + ", call=" + call + "]";
    }
}
