package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHookSender;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class DoorayMessageSenderTest {

    @Test
    public void testSendMessage_Success() {
        DoorayHookSender doorayHookSenderMock = Mockito.mock(DoorayHookSender.class);
        doNothing().when(doorayHookSenderMock).send(any());
        DoorayMessageSender doorayMessageSender = new DoorayMessageSender(doorayHookSenderMock, "testHookUrl");

        User user = new User("testFirstName", "testLastName");
        String message = "testMessage";

        boolean result = doorayMessageSender.sendMessage(user, message);
        assertTrue(result);
    }

    @Test
    public void testSendMessage_Failure() {

        DoorayHookSender doorayHookSenderMock = Mockito.mock(DoorayHookSender.class);
        doThrow(new RuntimeException()).when(doorayHookSenderMock).send(any());
        DoorayMessageSender doorayMessageSender = new DoorayMessageSender(doorayHookSenderMock, "testHookUrl");
        User user = new User("testFirstName", "testLastName");
        String message = "testMessage";
        boolean result = doorayMessageSender.sendMessage(user, message);
        assertFalse(result);
    }
}
