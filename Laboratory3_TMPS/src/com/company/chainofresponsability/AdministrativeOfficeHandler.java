package com.company.chainofresponsability;

public class AdministrativeOfficeHandler extends CallHandlerBase {

    @Override
    public PhoneCallResponse response(PhoneCall call) {
        if (status == Status.ONDESK) {
            System.out.println("Call:" + call.toString() + " received by the Office Administration");
            return PhoneCallResponse.ACCEPTED;
        }
        if (redirectedTo != null) {
            return redirectedTo.response(call);
        }
        return PhoneCallResponse.REJECTED;
    }
}