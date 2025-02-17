package com.example.codepathmail

class EmailFetcher {
    companion object {
        val senders = listOf(
            "Dahlia Cline",
            "Kevin Miranda",
            "Kaya Austin",
            "Laila Calderon",
            "Marquise Rhodes",
            "Fletcher Patel",
            "Luz Barron",
            "Kamren Dudley",
            "Jairo Foster",
            "Lilah Sandoval",
            "Ansley Blake",
            "Slade Sawyer",
            "Jaelyn Holmes",
            "Phoenix Bright",
            "Ernesto Gould"
        )
        val title = "Welcome to Kotlin!"
        val summary = "Welcome to the Android Kotlin Course! We're excited to have you join us and learn how to develop Android apps using Kotlin. Here are some tips to get started."

        fun getEmails(): MutableList<Email> {
            val emails: MutableList<Email> = ArrayList()
            for (i in 0..9) {
                val email = Email(
                    sender = senders[i],
                    title = title,
                    summary = summary,
                    date = "2024-09-19", // Example date, adjust as needed
                    senderImageRes = R.drawable.default_avatar // Use the default avatar for all
                )
                emails.add(email)
            }
            return emails
        }

        fun getNext5Emails(): MutableList<Email> {
            val newEmails: MutableList<Email> = ArrayList()
            for (i in 10..14) {
                val email = Email(
                    sender = senders[i],
                    title = title,
                    summary = summary,
                    date = "2024-09-19", // Example date, adjust as needed
                    senderImageRes = R.drawable.default_avatar // Use the default avatar for all
                )
                newEmails.add(email)
            }
            return newEmails
        }
    }
}
