**Conversation Log**


https://open.kattis.com/problems/conversationlog

Popular social networking site My+Din is struggling to manage its many popular forums. Recent regulation requires the site to report users engaged in conversations about certain topics. The sheer number of users means manual monitoring is too costly and so the site has asked its many interns to come up with a solution.

One intern has theorized that conversations about any given topic will see the same key words used over and over. If the most used words can be identified perhaps manual investigation can be directed towards appropriate forums.

Input
One line containing a single integer M (1≤M≤104), the number of messages.

M more lines each beginning with a user’s name of no more than 20 characters and continuing with the content of that user’s message all in lower case. The total number of characters across all messages, including spaces, will not exceed 2⋅106.

Output
Several words, one per line, listing the words used by every single user on the forum, ordered from most to least used and in case of a tie in alphabetical order. If there are no such words, output ALL CLEAR.

