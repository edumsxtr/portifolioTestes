Feature: Teste de Login Positivo

  Scenario: Positive LogIn test
    Given que eu esteja na página de login
    When eu insiro o nome de usuário "student" no campo de nome de usuário
    And eu insiro a senha "Password123" no campo de senha
    And eu clico no botão de envio
    Then a URL da nova página deve conter "practicetestautomation.com/logged-in-successfully/"
    And a nova página deve conter o texto esperado:
    """
    Congratulations student. You successfully logged in!
    """
    And o botão "Log out" deve estar visível na nova página

 Scenario: Negative username test
    Given que eu esteja na página de login
    When eu insiro o nome de usuário "incorrectUser" no campo de nome de usuário
    And eu insiro a senha "Password123" no campo de senha
    And eu clico no botão de envio
    Then uma mensagem de erro deve ser exibida
    And o texto da mensagem de erro deve ser "Seu nome de usuário é inválido!"

Scenario: Negative password test
    Given que eu esteja na página de login
    When eu insiro o nome de usuário "student" no campo de nome de usuário
    And eu insiro a senha "incorrectPassword" no campo de senha
    And eu clico no botão de envio
    Then uma mensagem de erro deve ser exibida
    And o texto da mensagem de erro deve ser "Sua senha é inválida!"
