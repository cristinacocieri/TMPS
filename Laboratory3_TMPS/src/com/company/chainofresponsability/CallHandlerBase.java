package com.company.chainofresponsability;

public abstract class CallHandlerBase {
    protected CallHandlerBase redirectedTo;
    protected Status status = Status.ONDESK;
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setRedirect(CallHandlerBase r) {
        redirectedTo = r;
    }
    public abstract PhoneCallResponse response(PhoneCall call);
}