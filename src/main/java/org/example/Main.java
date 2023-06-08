package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChat;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.pinnedmessages.PinChatMessage;
import org.telegram.telegrambots.meta.api.methods.pinnedmessages.UnpinChatMessage;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


import java.io.File;
import java.nio.LongBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main extends TelegramLongPollingBot {

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new Main());
    }
    @Override
    public String getBotUsername() {
        return "forestbowbot";
    }
    @Override
    public String getBotToken() {
        return "5939910298:AAEHapX4LZ5x_NRGP3UiT9EZ55cgNhcs6yM";
    }
    @Override
    public void onUpdateReceived(Update update) {

        Long chatId = getChatId(update);
        Long[] members = new Long[] { 259170911L, 309048052L, 863962911L, 530707150L };

        String messageText1 = "*Внимание!!! у нас бой*, по возможности заходим с умом @tvoy\\_bandit  @ilya\\_Ssssssss @Fiasko";
        String messageText2 = "@Rorshox @Bonnbl4 @IT1mig @tarasov\\_anton @Mifytkaa";

        if (update.hasMessage() && update.getMessage().getText().equals("/help@forestbowbot") || update.getMessage().getText().equals("/help")) {

            Integer messageId5 = getMessageId(update);

            SendMessage message2 = createMessage(messageText2);
            message2.setChatId(chatId);
            sendApiMethodAsync(message2);

            SendMessage message1 = createMessage(messageText1);
            message1.setChatId(chatId);
            sendApiMethodAsync(message1);

            //System.out.println(update.getMessage());

            SetChatPhoto setChatPhoto = setChatPhoto("red", chatId);

            DeleteMessage deletedMessage5 = deleteMessage(messageId5+3);
            deletedMessage5.setChatId(chatId);
            sendApiMethodAsync(deletedMessage5);

        }



        if (update.hasMessage() && update.getMessage().getText().equals("/ready@forestbowbot") || update.getMessage().getText().equals("/ready")) {

            Integer messageId6 = getMessageId(update);

            DeleteMessage deletedMessage5 = deleteMessage(messageId6);
            deletedMessage5.setChatId(chatId);
            sendApiMethodAsync(deletedMessage5);

            SetChatPhoto setChatPhoto = setChatPhoto("yellow", chatId);

            DeleteMessage deletedMessage7 = deleteMessage(messageId6+1);
            deletedMessage7.setChatId(chatId);
            sendApiMethodAsync(deletedMessage7);

            List<String> answer = List.of("Готов! я на связи!", "что-то у меня полные склады..");

            SendPoll poll = new SendPoll();
            poll.setChatId(chatId);
            poll.setQuestion("Лучник " + getChatFirstName(update) + " предлагает повоевать! Ты как?");
            poll.setOptions(answer);
            poll.setDisableNotification(false);
            poll.setIsAnonymous(false);
            poll.setType("quiz");
            poll.setCorrectOptionId(0);
            poll.setExplanation("Неправильный ответ! нам нужен каждый штык! а ты там в кладовщика играешь!");
            sendApiMethodAsync(poll);




            PinChatMessage pinChatMessage = new PinChatMessage();
            pinChatMessage.setChatId(chatId);
            pinChatMessage.setMessageId(messageId6+2);
            sendApiMethodAsync(pinChatMessage);

            DeleteMessage deletedMessage9 = deleteMessage(messageId6+3);
            deletedMessage9.setChatId(chatId);
            sendApiMethodAsync(deletedMessage9);


        }

        String messageText3 = "*Are you ready for battle? I'm ready!*";

        if (update.hasMessage() && update.getMessage().getText().equals("/ping@forestbowbot") || update.getMessage().getText().equals("/ping")) {

            Integer messageId = getMessageId(update);
            DeleteMessage deletedMessage = deleteMessage(messageId);
            deletedMessage.setChatId(chatId);
            sendApiMethodAsync(deletedMessage);

            SendMessage message3 = createMessage(messageText3);
            message3.disableNotification();
            message3.setChatId(chatId);
            sendApiMethodAsync(message3);

        }

        if (update.hasMessage() && update.getMessage().getText().equals(messageText3)) {
            Integer messageId2 = getMessageId(update);
            DeleteMessage deletedMessage2 = deleteMessage(messageId2+1);
            deletedMessage2.setChatId(chatId);
            sendApiMethodAsync(deletedMessage2);
        }

        if (update.hasMessage()) {
            System.out.println(update.getMessage());
        }

        if (update.hasMessage() && update.getMessage().getText().equals("/recall@forestbowbot") || update.getMessage().getText().equals("/recall")) {

            SetChatPhoto setChatPhoto = setChatPhoto("green", chatId);
            Integer messageId3 = getMessageId(update);
          //  DeleteMessage deletedMessage2 = deleteMessage(messageId3+1);
            DeleteMessage deletedMessage3 = deleteMessage(messageId3);
            deletedMessage3.setChatId(chatId);
            sendApiMethodAsync(deletedMessage3);

            DeleteMessage deletedMessage4 = deleteMessage(messageId3+1);
            deletedMessage4.setChatId(chatId);
            sendApiMethodAsync(deletedMessage4);

            String messageText4 = "Лучник *"+ getChatFirstName(update) + "* отменил тревогу. Фармим с умом и качаем казармы. \n *Кто отстроился - ставит лайк*";

            SendMessage message4 = createMessage(messageText4);
            message4.setChatId(chatId);
            sendApiMethodAsync(message4);


            UnpinChatMessage unPinChatMessage = new UnpinChatMessage();
            unPinChatMessage.setChatId(chatId);
            sendApiMethodAsync(unPinChatMessage);

            PinChatMessage pinChatMessage2 = new PinChatMessage();
            pinChatMessage2.setChatId(chatId);
            pinChatMessage2.setMessageId(messageId3+2);
            sendApiMethodAsync(pinChatMessage2);

        }


        if (update.hasMessage() && update.getMessage().getText().equals("/wakeUp") || isForbowMember(chatId, members)) {

            /////

            SendMessage message10 = createMessage("пора начать действовать! запустить новый таймер на 15 минут /wakeUp");
            message10.setChatId(chatId);
            sendApiMethodAsync(message10);

        }

    }


    public Long getChatId(Update update){
        if (update.hasMessage()){
            return update.getMessage().getChat().getId();
        }
        if (update.hasCallbackQuery()){
            return update.getCallbackQuery().getFrom().getId();
        }
        return null;
    }
    public String getChatFirstName(Update update){
        if (update.hasMessage() && update.getMessage().getFrom().getFirstName() != null){
            return update.getMessage().getFrom().getFirstName();
        }
        return "";
    }
    public String getChatLastName(Update update){
        if (update.hasMessage() && update.getMessage().getFrom().getLastName() != null){
            return update.getMessage().getFrom().getLastName();
        }
        return "";
    }
    public SendMessage createMessage(String text) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setParseMode("markdown");
        return message;
    }

    public DeleteMessage deleteMessage(Integer messageId) {
        DeleteMessage message = new DeleteMessage();
        message.setMessageId(messageId);
        return message;
    }
    public Integer getMessageId(Update update){
        if (update.hasMessage() && update.getMessage().getMessageId() != null){
            return update.getMessage().getMessageId();
        }
        return null;
    }


    public Boolean isForbowMember(Long chatId, Long[] members){
        boolean found = Arrays.asList(members).contains(chatId);
        return found;

    }



    public SetChatPhoto setChatPhoto(String namePhoto, Long chatId) {
        SetChatPhoto setChatPhoto = new SetChatPhoto();
        InputFile inputFile = new InputFile();
        inputFile.setMedia(new File("Images/" + namePhoto + ".jpg"));
        setChatPhoto.setPhoto(inputFile);
        setChatPhoto.setChatId(chatId);
        executeAsync(setChatPhoto);
        return setChatPhoto;
    }
}
