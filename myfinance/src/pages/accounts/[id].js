import { useRouter } from "next/router"

export default function AccountPage() {
    const router = useRouter()
    console.log(router)
    return (
        <div>
            <h1> An Account </h1>
            <h3> {router.query.id}</h3>
        </div>

    )
}