package com.company.chainofresponsability;

public class ReceptionHandler extends CallHandlerBase {

    @Override
    public PhoneCallResponse response(PhoneCall call) {
        if (status == Status.ONDESK) {
            System.out.println("Call:"+call.toString()+" received by the reception");
            return PhoneCallResponse.ACCEPTED;
        }
        if (redirectedTo != null) {
            return redirectedTo.response(call);
        }
        return PhoneCallResponse.REJECTED;
    }
}